import { HttpHeaders } from '@angular/common/http';
export class AppConstants {

    public static APP = 'sovis/';
    //Server
    public static SERVER = '../';
    public static IMGCART = './app/assets/shopping-cart.png';
    //local
    //public static SERVER = 'http://localhost:8080/';
    //public static IMGCART = './assets/shopping-cart.png';
    public static WEBAPP = 'http://localhost:4200/';
    public static SERVERPATH = AppConstants.SERVER + AppConstants.APP;
    public static headers() {
        return new HttpHeaders().set(
            "Content-Type",
            "application/x-www-form-urlencoded"
        )
    }

}