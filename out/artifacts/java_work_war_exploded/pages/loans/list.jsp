<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <h2>Empréstimos realizados</h2>
    <p>
        <a href="/lend-books?action=lend">Realizar novo Empréstimo</a>
    </p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome do Estudante</th>
            <th>Livro</th>
            <th>Data do empréstimo</th>
            <th>Data de entrega</th>
            <th>Status</th>
            <th colspan="2">Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${loans}" var="loan">
            <tr>
                <td><c:out value="${loan.id}" /></td>
                <td><c:out value="${loan.student.name}" /></td>
                <td><c:out value="${loan.book.name}" /></td>
                <td><c:out value="${loan.loanStartDate}" /></td>
                <td><c:out value="${loan.loanEndDate}" /></td>
                <td>
                    <c:if test="${loan.status == 0}">
                        Emprestado
                    </c:if>
                    <c:if test="${loan.status == 1}">
                        Devolvido
                    </c:if>
                </td>
                <td>
                    <c:if test="${loan.status == 0}">
                        <a href='/lend-books?action=returnBook&id=<c:out value="${loan.id}"/>'>Marcar como entregue</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${loans.size() == 0}">
            <tr>
                <td colspan="7" style="text-align:center;">Nenhum empréstimo emprestado.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
