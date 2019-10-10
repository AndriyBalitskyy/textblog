<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="${social_googleplus_clienId}">
<title>Andriy's pet blog</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="data:image/gif;base64,R0lGODlhIAAgAOf/ADEzMDo0LjY2O9oNHS09P101P1c4NTBCR2A3KHQwO8QaK4otL88aJWw3LL4gJL4gKcAhH5osMT1HO8khKdIeLURGQ9wcJssiJCpOYNUhKVxEQ94gLklLSFNJTENOTnFIGk5ORsAvLWFLPmVLNcwwMzpYZrY3QURWYIBJPT1bUideeoJITU5VZ1pWVVtVXyJjhFxbU0xhSWVaStQ7PVtcZT1oTRlskkNjfAB1psJHOzJxR5tVTWplZLdSQGNndAB+tRqEPXBpUXJnaACBvllxXR6FRppgU1B5V1V5TMdYRGtwZwCGzMxXSySLQ8pYXF51hdZXUrNjWHd2XFmCYGOAZTmGpziQSS+TSn14ceFdWT6PT85kU4J7URePxzaSURqOzESOWrdtXjeWRzqZSb1vbaF/KJZ7elOSZclxXDSfTlGMtk6WXCyVzaKBONxsYchxbTiTxXiJdyaY1mmQZ0GfT0WUwkagSkCiWNl2ZD6nVV2eZEumUWecbWWeZcWAdDqg0kmqTF6iYVuZz0Ohx0esU3WaflWoWU6h3O9+d1CxUnCkdlOwWJudU0y1TpCbis+JhtuHeu2CeFil2pybd32kel6k4NeKgIGjiPODgFi1Y1q5WauhY2ur3G61c2K8Y2a7bbKgn5WskZKujG6y2/KUg7WnfG/AaMykmdyhirCrqXjDcs2vPpa2nc2yJdikkZ63kIjBg4bDe4G65cy1Spm+jtS4Nqa8nuWrnZC+5dS2b43Jhda6RZjEntS7Vcy8Z9u/NN6/NdG8gMLDh+HEMLLFsd/EQcXEldvFZ5vM5uLIUKHUmejKN7POstTIkq3RrOrML9rOeqfZpfDQKKjZq/TDuuvGvO7UK57Z8dzQlvHWIObPi+zUXMfXveHSpu3XU9jXlPbbJvTbR7fiuOLYpOrZg/vfHt/dk+ban/bhLeTZuPzgLvnjIMrixvXmIvziQPnlPObgsfTlV/nmR/XoR/rnUePkufvnYvnoafnocfbqfPHouvPsw//vqP/yt//2mJCRlCH+EUNyZWF0ZWQgd2l0aCBHSU1QACH5BAEKAP8ALAAAAAAgACAAAAj+AP8JHEiwoMGDCBMqXMiwoUOC1W6hQnWr2kOE1Pyg2cIkSZItW9A8snhR4KkeeB48cLByZYgQOd6ULCQCCgkGOC9cYEBhggIFEEw8hDUF1IwMGSZAiRTJTQgKGSxcmPCgIaxolFLNGJAFkpEVKHZYQnTBAgWpThby8jQtWpxHWfwUoPHEhwsDYUhZiLphgCuFnRZ9ikULFJkOL+ocEqRmCIsomDZItsAkITNDhDSp0uXIjIo/h0bJ4iSnSwcECRZEeDCjG0JFezKb0sUMho0uknBdkyVp0A1jpbjI0NCgDUI9dPYk8qSLV4XbuZHJkgPnxCZ86ML5GvEBYaAxdBL+aXYmQcUSOZxGVZJT5cAme+vKZStWxvsVOoCWs4vhwcaSL2x88UMJAYwzzzrgSPNMLcd5MYYdhDSizCUVpPACDj/ggIEAQfTTTjnoPDNMLfAcBMYVVqRBSCKLiBOHBAIQcAABAIAAzz3xWbNgKwiBocUVYtgR2yfiXKJECxVwIMU++cSX4DK1rPLaGk1YIQYdeRCSyStYYFGPPvzg42Q20oyYC0LcrFFEE1dckcYdc/AwiT/53CMPOuWUA441I86STkJ8rAEEm2JQIYQw+NhDz51OKvjLLr4oZMsZWgBRBBFYmHNPPPS8o8468WVjzaO9NLMQK31YUUQF38Qjjzxa74CKIJnAFFNqQ6HooYUOk8zjDjrqlDOriMn0EsxDtvDBRw2MxLqOOjouk0wyx2BTEjGiUHIEI/G4E44322xzDDQlliQQN6xcgoQw5JCjzTnmxivvvPTWW1JAADs=" />

<link rel="stylesheet" type="text/css" href="/static/css/foundation.css">
<link rel="stylesheet" type="text/css"
	href="/static/css/foundation-icons.css">
<link rel="stylesheet" type="text/css" href="/static/css/app.css">
</head>
<body>
	<header>
		<jsp:include page="fragment/header.jsp" />
	</header>
	<div class="row">
		<nav role="navigation" class="large-12 small-6 medium-8 columns">
			<jsp:include page="fragment/breadcrumbs.jsp" />
		</nav>
		<div class="small-6 medium-4 columns">
			<jsp:include page="fragment/categories-dropdown.jsp" />
		</div>
	</div>
	<section class="row">
		<div id="mainContent" class="large-10 columns"
			style="min-height: 600px;">
			<jsp:include page="${currentPage}" />
		</div>
		<div class="columns large-2 show-for-large right"
			data-sticky-container>
			<div class="sticky categories show-for-large" data-sticky
				data-anchor="mainContent">
				<jsp:include page="fragment/categories-table.jsp" />
			</div>
		</div>
	</section>
	<footer class="footer">
		<jsp:include page="fragment/footer.jsp" />
	</footer>
	<script src="/static/js/jquery.js"></script>
	<script src="/static/js/what-input.js"></script>
	<script src="/static/js/foundation.js"></script>
	<script src="/static/js/app.js"></script>
	<script src="/static/js/messages.jsp"></script>
</body>
</html>