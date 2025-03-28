package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    //Page elements

    public By SwagLabsLogo = By.className("app_logo");
    public By Cart_Btn = By.className("shopping_cart_link");
    public By Menu = By.id("react-burger-menu-btn");
    public By AllItems_Menu = By.xpath("//*[@id=\"inventory_sidebar_link\"]");
    public By About_Menu = By.xpath("//*[@id=\"about_sidebar_link\"]");
    public By Logout_Menu = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    public By ResetAppState_Menu = By.xpath("//*[@id=\"reset_sidebar_link\"]");
    public By Twitter_btn = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
    public By Facebook_btn = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    public By Likedin_btn = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");
    public By addToCartButtons =By.xpath("//button[text()='Add to cart']") ;
    public By removeButtons = By.xpath("//button[text()='Remove']");
    public By inventoryContainer = By.id("inventory_container");
    
    
    

    //Lists of items elements
    public boolean isInventoryDisplayed(){
       return driver.findElement(inventoryContainer).isDisplayed();
    }
    public int getInventoryItemCount(){
       return driver.findElements(By.className("inventory_item")).size();
   }
    public List<WebElement> GetaddtocartButtons(){
        return driver.findElements(addToCartButtons);
    }
    public List<WebElement> GetremovesButtons(){
        return driver.findElements(By.xpath("//button[text()='Remove']"));
    }
   public void clickAllAddToCartButtons() {
        List<WebElement> addButtons = driver.findElements(addToCartButtons);

        System.out.println("Total Add to Cart buttons found: " + addButtons.size());

        for (WebElement button : addButtons) {
            button.click();
        }
    }
   public int getRemoveButtonsCount() {
        return driver.findElements(removeButtons).size();
    }
    public int getCartItemCount() {
        try {
            WebElement cartBadgeElement = driver.findElement(Cart_Btn);
            return Integer.parseInt(cartBadgeElement.getText());
        } catch (Exception e) {
            return 0; // No badge means no items in the cart
        }
    }

    public List<WebElement> getItemsName() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public List<WebElement> getItemsPrice() {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public List<WebElement> getItemsAddToCart() {
        return driver.findElements(By.className("btn btn_primary btn_small btn_inventory"));
    }


    //sort dropdown list
    //Method to select by index
    public String selectSortingOptionByIndex(int index) {
        WebElement dropdownElement = driver.findElement(By.className("product_sort_container"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
        return dropdown.getFirstSelectedOption().getText();
    }



    //for By elements
    public void ClickOn(By Button){

        driver.findElement(Button).click();
    }


    //for WebElements
    public void ClickOn(WebElement button) {
        button.click();
    }
}
