<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表</title>
</head>
<body>
<div align="center">
  <table border="1">
    <tr>
    <th></th>
    <th>产品ID</th>
    <th>产品名称</th>
    <th>产品备注</th>    
    </tr>
 <s:iterator value="productType">
    <tr>
       <td><a href="<s:url action="add_updateUi"><s:param name="typeId" value="typeId"></s:param></s:url>">修改</a></td>
       <td><s:property value="typeId"/></td>
       <td><a href="<s:url action="list"><s:param name="parentId" value="typeId"></s:param></s:url>"><s:property value="name"/><s:if test="children.size()>0"><font color="#FF0000"><s:property value="'(有'+children.size()+'个子类)'"/></font></s:if></a></td>
       <td><s:property value="note"/></td>       
    </tr>
 </s:iterator>
  </table>
     <s:url id="url_pre" value="list.do">
         <s:param name="firstIndex" value="firstIndex-1"></s:param>
     </s:url>
     <s:url id="url_next" value="list.do">
         <s:param name="firstIndex" value="firstIndex+1"></s:param>
     </s:url>
<%--  <s:iterator value="productType">   
     <s:url id="url" action="list">
         <s:param name="parentid" value="typeId"/>
     </s:url>
 </s:iterator>  --%>    
     <input type="button" value="添加类型" onclick="javascript:window.location.href='<s:url value="add_addUi.do"><s:param name="parentid" value="#parameters.parentId"></s:param></s:url>'" >
     <input type="button" value="查询" onclick="javascript:window.location.href='<s:url value="add_queryUi.do"></s:url>'" >
     <s:if test="#currentPage>0"><a href='<s:url action="list"><s:param name="firstIndex" value="firstIndex-1"></s:param><s:param name="parentId" value="#parameters.parentId"></s:param><s:param name="query" value="query"></s:param><s:param name="name" value="name"></s:param></s:url>'>上一页</a></s:if>
     <s:else>上一页</s:else>     
     
    
     <s:if test="#totalPage>#currentPage+1"><a href='<s:url action="list"><s:param name="firstIndex" value="firstIndex+1"></s:param><s:param name="parentId" value="#parameters.parentId"></s:param><s:param name="query" value="query"></s:param><s:param name="name" value="name"></s:param></s:url>'>下一页</a></s:if>
     <s:else>下一页</s:else> 
     当前页：${currentPage+1 }|总页数：${totalPage }
  </div>
request:<s:property value="#request.parentid" escapeHtml="false"/><br/>
session:<s:property value="#session.parentid"/><br/>
application:<s:property value="#application.parentid"/><br/>
parameters:<s:property value="#parameters.parentid"/><br/>
</body>
</html>