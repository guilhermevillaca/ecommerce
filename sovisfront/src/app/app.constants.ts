import { HttpHeaders } from '@angular/common/http';
export class AppConstants {

    public static APP = 'ecommercesovis/';
    public static SERVER = 'http://localhost:8080/';
    public static WEBAPP = 'http://localhost:4200/';
    public static SERVERPATH = AppConstants.SERVER + AppConstants.APP;
    public static headers() {
        return new HttpHeaders().set(
            "Content-Type",
            "application/x-www-form-urlencoded"
        )
    }

}