<html>
<head>
    <title>${bookInstance?.title}</title>
    <meta name="layout" content="main" />
</head>
<body>
<div id="content" role="main">
    <section class="row colset-2-its">
        <g:if test="${bookInstance}">
            <h1><a href="${bookInstance.href}">${bookInstance.title}</a></h1>
            <p>${bookInstance.about}</p>
            <h2><g:message code="book.author" args="[bookInstance.author]" default="By {0}"/></h2>
            <asset:image src="${bookInstance.image}" width="200" />

        </g:if>
    </section>
</div>
</body>
</html>