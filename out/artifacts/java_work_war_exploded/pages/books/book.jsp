<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <form action="/books" method="POST">
        <fieldset>
            <input type="hidden" name="id" value="<c:out value="${book.id}" />">
            <div class="form-group">
                <label for="name">Nome do livro</label>
                <input type="text" name="name" class="form-control" value="<c:out value="${book.name}" />" placeholder="Nome do livro" />
            </div>
            <div class="form-group">
                <label for="author">Nome do autor</label>
                <input type="text" name="author" class="form-control" value="<c:out value="${book.author}" />" placeholder="Nome do autor" />
            </div>
            <div class="form-group">
                <label for="edition">Edição</label>
                <input type="text" name="edition" class="form-control" value="<c:out value="${book.edition}" />" placeholder="Edição" />
            </div>
            <div class="form-group">
                <label for="page_number">Número de Páginas</label>
                <input type="text" name="page_number" class="form-control" value="<c:out value="${book.pageNumber}" />" placeholder="Número de Páginas" />
            </div>
            <input type="submit" class="btn btn-default" value="Salvar" />
        </fieldset>
    </form>
</div>