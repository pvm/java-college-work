<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <form action="/lend-books" method="POST">
        <fieldset>
            <input type="hidden" name="id">
            <div class="form-group">
                <label for="loan_start_date">Data do empréstimo</label>
                <input type="text" name="loan_start_date" id="loan_start_date" class="form-control" placeholder="Data do empréstimo" />
            </div>
            <div class="form-group">
                <label for="loan_end_date">Data de entrega</label>
                <input type="text" name="loan_end_date" id="loan_end_date" class="form-control"placeholder="Data de entrega" />
            </div>
            <div class="form-group">
                <label for="book_id">Livro</label>
                <select id="book_id" name="book_id" class="form-control">
                    <option value="">Selecione um livro</option>
                    <c:forEach items="${books}" var="book">
                        <option value="<c:out value="${book.id}" />"><c:out value="${book.name}" /></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="student_id">Aluno</label>
                <select id="student_id" name="student_id" class="form-control">
                    <option value="">Selecione um aluno</option>
                    <c:forEach items="${students}" var="student">
                        <option value="<c:out value="${student.id}" />"><c:out value="${student.name}" /></option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" class="btn btn-default" value="Salvar" />
        </fieldset>
    </form>
</div>