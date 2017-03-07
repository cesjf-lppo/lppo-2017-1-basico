<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Produto</title>
    </head>
    <body>
        <h1>Novo Produto</h1>
        <form method="post">
            <label>Nome produto:
                <input type="text" name="nome"/>
            </label>
            <label>Quantidade:
                <input type="number" name="qtd" min="1" />
            </label>
            <input type="submit" />
        </form>
    </body>
</html>
