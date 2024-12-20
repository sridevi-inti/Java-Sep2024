<%@include file="header.html"%>
<html>
<head>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>View by Group</h2>
	</center>
	<!--Body: view by group information-->
	<center>
		<form method="post" action="/mysite/servlet/viewallbygroup">
			<table cellpadding="0" cellspacing="0" width="50%"">
				<tr>

					<label for="groupId">GroupId:</label>

					<select name="GroupId">
						<option value="friends">Friends</option>
						<option value="personal">Personal</option>
						<option value="relatives">Relatives</option>


					</select>

					<br>
					<br>

					<style>
.button {
border-radius: 1000px;}

GroupId span {
    display: block;
    padding-top: 22px;
    text-align: center;
    line-height: 1em;
}
</style>
					<input type="submit" value="View by Group">
				</tr>
				<tr>
					<td colspan="2" align="right"><br>
						<table width="50%">

						</table></td>
				</tr>
			</table>
		</form>
	</center>
</body>



</html>
<%@include file="footer.html"%>

</body>
