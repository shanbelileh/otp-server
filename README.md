````
 _____  _              _         _  _  _       _   
|   __|| |_  ___  ___ | |_  ___ | ||_|| | ___ | |_ 
|__   ||   || .'||   || . || -_|| || || || -_||   |
|_____||_|_||__,||_|_||___||___||_||_||_||___||_|_|

````
A small and easy-to-use one-time password generator server with spring boot & kotlin according to  [RFC 6238](https://tools.ietf.org/html/rfc6238) (TOTP).

Run the application
```shell
./mvnw spring-boot:run
```

## Usage
#### Request OTP 

```http request
POST localhost:8585/api/otp/{{user-name}}/generate
```
#### Validate OTP

```http request
GET localhost:8585/api/otp/{{user-name}}/validate/{{otp}}
```

