<#ftl output_format="HTML">
<h3>HTTP ${data.responseCode?c}</h3>
<h4>Headers</h4>
<ul>
<#list data.headers as name, value>
    <li>${name}: <#if ["authorization", "set-cookie", "cookie", "x-api-key"]?seq_contains(name?lower_case)>[REDACTED]<#else>${value}</#if></li>
</#list>
</ul>
<#if data.body??>
<h4>Body</h4>
<pre>${data.body}</pre>
</#if>
