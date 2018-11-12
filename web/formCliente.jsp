<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form action="cliente" method="POST">

    <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" name="nome">
    </div>

    <div class="form-group">
        <label for="email">E-mail</label>
        <input type="email" class="form-control" name="email">
    </div>

    <div class="form-group">
        <label for="dataNasc">Data Nascimento</label>
        <input type="date" class="form-control" name="dataNasc">
    </div>

    <div class="form-group">
        <label for="pws">Senha</label>
        <input type="password" class="form-control" name="pws">
    </div>

    <div class="form-group">
        <label for="confpws">Confirmação de Senha</label>
        <input type="password" class="form-control" name="confpws">
    </div>

    <button type="submit" class="btn btn-primary">Salvar</button>
</form>
