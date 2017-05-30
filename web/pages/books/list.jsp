<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <h2>Livros</h2>
    <p>
        <a href="/books?action=create">Adicionar Livro</a>
    </p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome do Livro</th>
            <th>Autor</th>
            <th>Edição</th>
            <th>Número de páginas</th>
            <th colspan="2">Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td><c:out value="${book.name}" /></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.edition}" /></td>
                <td><c:out value="${book.pageNumber}" /></td>
                <td><a href='/books?action=edit&id=<c:out value="${book.id}"/>'>Editar</a></td>
                <td><a href='/books?action=delete&id=<c:out value="${book.id}"/>'>Excluir</a></td>
            </tr>
        </c:forEach>
        <c:if test="${books.size() == 0}">
            <tr>
                <td colspan="7" style="text-align:center;">Nenhum livro emprestado.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
