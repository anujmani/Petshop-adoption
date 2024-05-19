import { HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginServiceService } from "./login-service.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{
    constructor(private login:LoginServiceService){

    }
    intercept
        (
            req: HttpRequest<any>,
            next:HttpHandler
            
        ):Observable<HttpEvent<any>>{
            let authreq=req;
            const token=this.login.getToken();
            console.log("Inside the interceptor")

            if(token!=null)
            {
                console.log("interceptors");
                authreq=authreq.clone({setHeaders:{Authorization:`Bearer ${token}`},
            });

            }
            return next.handle(authreq);
        }
    }
export const authInterceptorProviders=[
    {provide:HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi:true,
}
]