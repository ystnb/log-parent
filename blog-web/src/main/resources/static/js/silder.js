var obj=null;
var As=document.getElementById('topnav').getElementsByTagName('a');
obj = As[0];
for(i=1;i<As.length;i++){if(window.location.href.indexOf(As[i].href)>=0)
obj=As[i];}
obj.id='topnav_current'

var request = { 
QueryString : function(val) { 
var uri = window.location.search; 
var re = new RegExp("" +val+ "\=([^\&\?]*)", "ig"); 
return ((uri.match(re))?(uri.match(re)[0].substr(val.length+1)):null); 
}
}