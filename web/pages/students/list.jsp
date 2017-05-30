<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <h2>Estudantes</h2>
    <p>
        <a href="/students?action=create">Adicionar Estudante</a>
    </p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome do Estudante</th>
            <th>RA</th>
            <th>Course</th>
            <th>Telefone</th>
            <th colspan="2">Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><c:out value="${student.name}" /></td>
                <td><c:out value="${student.ra}" /></td>
                <td><c:out value="${student.course}" /></td>
                <td><c:out value="${student.phone}" /></td>
                <td><a href='/students?action=edit&id=<c:out value="${student.id}"/>'>Editar</a></td>
                <td><a href='/students?action=delete&id=<c:out value="${student.id}"/>'>Excluir</a></td>
            </tr>
        </c:forEach>
        <c:if test="${students.size() == 0}">
            <tr>
                <td colspan="7" style="text-align:center;">Nenhum aluno emprestado.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
