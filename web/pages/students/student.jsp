<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
    <form action="/students" method="POST">
        <fieldset>
            <input type="hidden" name="id" value="<c:out value="${student.id}" />">
            <div class="form-group">
                <label for="name">Nome do Estudante</label>
                <input type="text" name="name" class="form-control" value="<c:out value="${student.name}" />" placeholder="Nome do Estudante" />
            </div>
            <div class="form-group">
                <label for="ra">RA</label>
                <input type="text" name="ra" class="form-control" value="<c:out value="${student.ra}" />" placeholder="RA" />
            </div>
            <div class="form-group">
                <label for="course">Curso</label>
                <input type="text" name="course" class="form-control" value="<c:out value="${student.course}" />" placeholder="Curso" />
            </div>
            <div class="form-group">
                <label for="phone">Telefone</label>
                <input type="text" name="phone" class="form-control" value="<c:out value="${student.phone}" />" placeholder="Telefone (xx) xxxxx-xxxx" />
            </div>
            <input type="submit" class="btn btn-default" value="Salvar" />
        </fieldset>
    </form>
</div>