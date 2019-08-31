# DNS-Rest-server
RESTful dns server with CRUD operations

GET http://localhost:8080/DNS-Server/dns

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>

    <dnsModel>
        <address>192.168.0.1</address>
        <domen>vk.com</domen>
        <id>1</id>
    </dnsModel>
    <dnsModel>
        <address>192.168.7.1</address>
        <domen>netcracker.edu</domen>
        <id>2</id>
    </dnsModel>
    <dnsModel>
        <address>192.168.11.1</address>
        <domen>hello.edu.com</domen>
        <id>3</id>
    </dnsModel>
    <dnsModel>
        <address>192.168.6.1</address>
        <domen>my.site.ru</domen>
        <id>4</id>
    </dnsModel>
    <dnsModel>
        <address>192.145.0.1</address>
        <domen>oracle.edu.org</domen>
        <id>5</id>
    </dnsModel>
    <dnsModel>
        <address>192.168.0.38</address>
        <domen>hello.com.org</domen>
        <id>6</id>
    </dnsModel>
    <dnsModel>
        <address>192.126.0.1</address>
        <domen>steamcommunity.com</domen>
        <id>7</id>
    </dnsModel>
    <dnsModel>
        <address>158.145.157.15</address>
        <domen>youtube.com</domen>
        <id>8</id>
    </dnsModel>


GET http://localhost:8080/DNS-Server/dns/5

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <dnsModel>
       <address>192.145.0.1</address>
       <domen>oracle.edu.org</domen>
       <id>5</id>
    </dnsModel>

POST http://localhost:8080/DNS-Server/dns/add

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<dnsModel>
        <address>127.0.0.1</address>
        <domen>localhost.ru</domen>
    </dnsModel>
	
Record added

PUT http://localhost:8080/DNS-Server/dns/update

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<dnsModel>
        <address>127.0.0.1</address>
        <domen>myapp.ru</domen>
        <id>9</id>
    </dnsModel>
	
Record updated

DELETE http://localhost:8080/DNS-Server/dns/9

Record deleted
