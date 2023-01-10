<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>

<div id="app">
<ul>
<li v-for="item in data">
{{item.activeName}}
{{item.activeDescription}}
{{item.activeStartDate}}
</li>
</ul>
</div>

<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.x"></script>
<script type="text/javascript">

var vue = new Vue({
	  el: '#app',
	  data: function () {
	    return {
	      data: {
		      

		      }
	    }
	  },
	  methods: {},
	  mounted: function () {
	    axios.get('http://localhost:8080/Spring/actives')
	      .then(response => {
	        console.log(response.data);
// 	        var jsonObj = JSON.parse(JSON.stringify(response.data));

	    
	        this.data = response.data
	      })
	  }
	});



</script>
</body>
</html>