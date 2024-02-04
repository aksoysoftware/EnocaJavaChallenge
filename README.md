# Enoca Java Challenge 
 


## Proje Bilgileri
#### • Java 17
#### • Spring Boot 3.2.2
#### • Spring Data JPA ve JDBC
#### • MySQL 
#### • Spring Web
#### • Springfox Swagger UI
#### • Spring Boot Test Starter



![image](https://github.com/aksoysoftware/EnocaJavaChallenge/assets/99371051/3f78d5bc-d738-44c6-8b77-8c72e676ece1)

![image](https://github.com/aksoysoftware/EnocaJavaChallenge/assets/99371051/d6f444ca-e11f-4b70-a29c-095c1d38c676)

### /carts/{customerId}/addProduct
Müşterinin sepeti yoksa, müşteri için yeni bir sepet oluşturulur.
Belirtilen ürün bulunamazsa veya istenen miktar mevcut stoku aşarsa, işlem başarısız olur.
Ürün ekledikten sonra sepetin toplam fiyatı güncellenir.
Eklenen ürünün stoku eklenen ürün sayısına göre göre azaltılır.


### /carts/{customerId}/removeProduct
Sepette belirtilen ürün bulunamazsa veya istenen miktar, sepetteki mevcut miktardan fazlaysa işlem başarısız olur.
Ürün çıkarıldıktan sonra sepetin toplam fiyatı güncellenir.
Çıkarılan ürünün stoku buna göre artırılır.


### /carts/{customerId}/empty
Sepetin içindeki tüm ürünler ve toplam fiyat sıfırlanır.


### /carts/{customerId}
Spesifik bir kullanıcının sepetini getirir.


![image](https://github.com/aksoysoftware/EnocaJavaChallenge/assets/99371051/d797f292-64ee-49b7-8046-4cb8a58a5c31)
![image](https://github.com/aksoysoftware/EnocaJavaChallenge/assets/99371051/8a32700e-3ef6-4401-a9ae-9438eafd32ef)


### /orders/placeOrderCart(POST) & /placeOrderByCustomer/{customerId}(POST)
Oluşturulan sipariş bilgileri keydedilir.
işlem yapılan sepet boşaltılır.


 ![image](https://github.com/aksoysoftware/EnocaJavaChallenge/assets/99371051/29ddb4cf-b363-4982-8aff-cd11ff25c4c2)
### /products/{productId}(PUT)
Güncellenen ürün bilgileri ve stok miktarı veritabanına kaydedilir.
Aynı zamanda ürün fiyatının ve stok miktarının değişim geçmişi (ProductPriceHistory) kaydedilir.


### /products (POST)
Oluşturulan ürün bilgileri ve ürünün oluşturulma tarihi veritabanına kaydedilir.



 
  
![image](https://github.com/aksoysoftware/EnocaJavaChallenge/assets/99371051/794ead3b-e634-489f-b6c4-dde1652cd6d9)


 






 

 









