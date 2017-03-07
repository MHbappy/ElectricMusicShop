<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>




<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Fill the below information to add a product : </p>
        </div>


        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" commandName="product" enctype="multipart/form-data">

        <div class="form-group">
            <label for="name">Name</label>
            <form:errors path="productName" cssStyle="color: #b92c28"/>
            <form:input path="productName" id = "name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument"/>Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record"/>Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory"/>Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:input path="productDescription" id = "description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:errors path="productPrice" cssStyle="color: #b92c28"/>
            <form:input path="productPrice" id = "price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondiation" id="condition" value="new"/>New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondiation" id="condition" value="used"/>Used</label>
        </div>


        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active"/>Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive"/>Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStoke">Unit In Stock</label>
            <form:errors path="unitInStoke" cssStyle="color: #b92c28"/>
            <form:input path="unitInStoke" id = "unitInStoke" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturers</label>
            <form:input path="productManufacture" id = "manufacturer" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="productImage">Manufacturers</label>
            <form:input path="productImage" id = "productImage" type="file" class="form:input-large"/>
        </div>

        <br><br>

        <input type="submit" value="submit" class="btn btn-default">

        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default" ></a>



        </form:form>




<%@include file="/WEB-INF/view/template/footer.jsp"%>