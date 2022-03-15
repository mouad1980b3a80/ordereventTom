<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
                xmlns:f="http://xmlns.jcp.org/jsf/core"
                xmlns:h="http://xmlns.jcp.org/jsf/html"
                xmlns:c="http://java.sun.com/jsp/jstl/core"
                template="/WEB-INF/layout/template.xhtml">

    <ui:define name="pageTitle">LsVaLMAP LIST</ui:define>
    <ui:define name="content">
        <div class="row">
            <div class="col-md-4 col-xs-12">
                <div class="card">
                    <!-- Default panel contents -->
                    <div class="card-header">
                        <i class="fa fa-list-alt" aria-hidden="true"></i>
                        TODO
                    </div>
                    <div class="card-body">
                        <p class="card-text">LsVaLMAP newly added in the backlog.</p>
                    </div>

                    <!-- List group -->
                    <c:if test="${not empty allLsValMAPs}">
                        <ul id="allLsValMAPs" class="list-group list-group-flush">
                            <c:forEach var="lsValMAPs" begin="0" items="${allLsValMAPs}">
                                <li class="list-group-item">
                                    <h4>
                                        <span>#${lsValMAP.mapid} ${lsValMAP.mapq}</span> <span class="pull-right">
                                            <c:set var="lsValMAPUrl" value="#{request.contextPath}/mvc/LsVaLMAPs/#{lsValMAP.id}" />
                                            <c:set var="lsValMAPEditUrl" value="#{request.contextPath}/mvc/LsVaLMAPs/#{lsValMAP.id}/edit" />
                                            <a href="${lsValMAPUrl}"> 
                                                <span class="fa fa-file" aria-hidden="true"></span>
                                            </a> 
                                            <a href="${lsValMAPEditUrl}"> 
                                                <span class="fa fa-edit" aria-hidden="true"></span>
                                            </a>
                                        </span>
                                    </h4>
                                    <p>${lsValMAP.valueOrig}</p>
                                    <p>
                                        <c:set var="markDoingUrl"
                                               value="#{request.contextPath}/mvc/LsVaLMAPs/#{lsValMAP.id}/status" />
                                        <!--    <form action="${markDoingUrl}" method="post">
                                            <input type="hidden" name="${mvc.csrf.name}"
                                                     value="${mvc.csrf.token}"/>
                                            <input type="hidden" name="_method" value="PUT"></input>
                                            <input type="hidden" name="status" value="DOING"></input>
                                            <button type="submit" class="btn btn-sm btn-primary">
                                                <span class="fa fa-play" aria-hidden="true"></span>
                                                START
                                            </button>
                                        </form> -->
                                    </p>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
    </ui:define>
</ui:composition>


