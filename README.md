<h1>
    <span style="color:blue;">Project Micro Service Online Learning</span>
</h1>

<h2 >
    <b>Getting Started with Micro Service Architecture</b>
</h2>

<div align="center">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1Pf3tnfaB7TSel3956iCCQp_IZ1Fka3UNvw&usqp=CAU" alt="Project Logo" style="width:100px; height:100px;">

</div>

<p align="center">
    In this application, we have a total of 8 microServices:
</p>

<p>
    <img src="https://img.shields.io/badge/MicroServices-8-brightgreen" alt="MicroServices">
</p>

<table>
  <thead>
    <tr>
      <th>MicroService</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Api-Gateway</td>
      <td>API management tool that sits between a client and a collection of backend services.</td>
    </tr>
    <tr>
      <td>Eureka-Server-MS</td>
      <td>This micro service is our discovery Server.</td>
    </tr>
    <tr>
      <td>User-Service</td>
      <td>This micro service is designed to manage all Users.</td>
    </tr>
    <tr>
      <td>Chat-Service</td>
      <td>This micro service is designed to manage the Chat system.</td>
    </tr>
    <tr>
      <td>Inscription-Service</td>
      <td>This micro service is designed to manage all the Leave.</td>
    </tr>
    <tr>
      <td>Course-Service</td>
      <td>This micro service is designed to manage Inscriptions.</td>
    </tr>
    <tr>
      <td>Evaluation-Service</td>
      <td>This micro service is designed to manage Tests controle.</td>
    </tr>
    <tr>
      <td>Calendar-Server</td>
      <td>This micro service is designed to manage the Calendar.</td>
    </tr>
  </tbody>
</table>

<p>
    <img src="https://img.shields.io/badge/MSs_&_their_PORTS-8-brightgreen" alt="MSs & their PORTS">
</p>

<table>
  <thead>
    <tr>
      <th>MicroService</th>
      <th>Local PORT</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Eureka-Server</td>
      <td>8761</td>
    </tr>
    <tr>
      <td>Api-Gateway</td>
      <td>9020</td>
    </tr>
    <tr>
      <td>Chat-Service</td>
      <td>8890</td>
    </tr>
    <tr>
      <td>Course-Service</td>
      <td>8091</td>
    </tr>
    <tr>
      <td>Calendar-Service</td>
      <td>8092</td>
    </tr>
    <tr>
      <td>Inscription-Service</td>
      <td>8093</td>
    </tr>
    <tr>
      <td>Evaluation-Service</td>
      <td>8095</td>
    </tr>
    <tr>
      <td>Chat-Service</td>
      <td>5263</td>
    </tr>
  </tbody>
</table>

<h3>
    <b>How to run this application:</b>
</h3>

<ol>
    <li>Download the code of this repository.</li>
    <li>Install all the dependencies.</li>
    <li>Run <code>mvn clean install</code> for all the microservices.</li>
    <li>Go to the root folder, then run <code>docker-compose up</code>.</li>
</ol>
