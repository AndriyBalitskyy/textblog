<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script src="https://apis.google.com/js/platform.js" async="true" defer></script>


<div class="article thumbnail">
	<c:set var="category" value="${CATEGORY_MAP[article.idCategory]}" />
	<img src="${article.logo}" 
		alt="${article.title}">
	<div class="data">
		<h3>${article.title}</h3>
		<ul class="vertical large-horizontal menu">
			<li><i class="fi-folder"></i><a href="/news${category.url}">${category.name}</a></li>
			<li><i class="fi-comments"></i><fmt:formatNumber value="${article.comments}" /> comments</li>
			<li><i class="fi-clock"></i><fmt:formatDate value="${article.created}" dateStyle="FULL" timeStyle="SHORT" type="both"/> </li>
			<li><i class="fi-eye"></i>Hits: <fmt:formatNumber value="${article.views}" /> </li>
		</ul>
		<hr>
		<div class="content">
			${article.content}
		</div>
		<div class="addthis_inline_follow_toolbox"></div>
		<br>
		<div class="comments">
			<jsp:include page="../fragment/new-comment.jsp" />
			<div id="comments-list-container" data-comments-count="${article.comments}" data-id-article="${article.id}">
				<jsp:include page="../fragment/comments.jsp" />
			</div>
			<div id="comments-load-more-ctrl" class="row column text-center">
				<a href="javascript:moreComments();" class="button hollow expanded load-more-btn" ${article.comments > fn:length(comments) ? '' : 'style="display:none"' } >Load
					More</a>
				<img src="/static/img/loading.gif" alt="Loading..." class="loading-indicator" />
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5d6baa49bfb22148"></script>