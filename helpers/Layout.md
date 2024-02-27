

#### **1. The Dependencies**

Before you can use layout pages in your Spring application, you need to add two dependencies:

1. the thymeleaf dependency
2. the layout-dialect dependency
3. These two dependencies are given below:

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
    <groupId>nz.net.ultraq.thymeleaf</groupId>
    <artifactId>thymeleaf-layout-dialect</artifactId>
    <version>2.5.1</version>
</dependency>
```


#### **2. The Layout Page**

The layout page is similar to any other HTML page. However, you must add the xmlns:layout attribute to the  html tag. This is shown below:

```
<html lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
```

Next, you need to specify the part of the layout page where you want the content to appear. This is done using a div tag with the fragment attribute. So anything outside this div tag would remain fixed while the content of the div tag would be changing. The code below shows how you do this.

```
<div layout:fragment="content">
    <p>Changing contents</p>
</div>
```


#### **3. The Content Page**

Just like in the layout page, you need to add the* xmlns:layout* attribute. But additionally, you also must add the *layout: decorate* attribute as well. The layout:decorate attribute would have a value set to the layout page(without the .html extension).  This is shown below:

```
<html lang="en" 
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="_layout">
```


Here, the layout page is *_layout.html* placed inside the templates folder.

Having added this HTML markup, you then need to specify the div tag that would wrap the whole content of the page. This is done as shown below:


```
<div layout:fragment="content">

<!--Content of the page-->

</div>
```
