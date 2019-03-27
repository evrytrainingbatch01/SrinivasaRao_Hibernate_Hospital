<html>
<body>
<h2>Hospital Form:</h2>

<form action="/Hospital/postdata" method="post">
  Patient Name:<input type="text" name="patient_name"><br>
 
  Age:
  <input type="text" name="age"><br>
  
  Blood Group:
  <input type="text" name="blood_group"><br>
  Checkup:<br>
  <input type="radio" name="checkup" value="IP">IP</input><br>
  <input type="radio" name="checkup" value="Emergency">Emergency</input><br>
  Doctor:
  <select name="doctor_name">
    <option value="Srinivasa Rao">Srinivasa Rao</option>
    <option value="Swaroop">Swaroop</option>
    <option value="Indra">Indra</option>
    <option value="Manoj">Manoj</option>
  </select><br>
  Test Recommended:
  <select name="Test">
    <option value="Blood">Blood</option>
    <option value="Brain">Brain</option>
    <option value="Urine">Urine</option>
    <option value="Lungs">Lungs</option>
  </select><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>
