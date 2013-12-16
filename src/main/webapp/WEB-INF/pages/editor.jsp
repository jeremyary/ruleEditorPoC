<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/editor.js"></script>
</head>
<body>

<div id="leftBar">
    <span>Drag to stage to add rule --></span>
</div>
<div id="container">
    <div class="ruleBox" data-ruleType="MathEqualityRuleType">
        <div class="title">Occupant Age</div>
    </div>
    <div class="ruleBox" data-ruleType="booleanRuleType">
        <div class="title">Maintenance Required</div>
    </div>
    <div class="ruleBox" data-name="">
        <div class="title">Rule Type 3</div>
    </div>
    <div class="ruleBox" data-name="">
        <div class="title">Rule Type 4</div>
    </div>
    <div class="ruleResult">
        [create rule to see result here]
    </div>
</div>
<div id="ruleStageContainer"></div>

<script language="JavaScript">
    var url = {
        // url's we'll want inside .js files from MVC
        ruleTypeTarget: "${pageContext.request.contextPath}/rulemarkup",
        process: "${pageContext.request.contextPath}/process"
    };
</script>
</body>
</html>