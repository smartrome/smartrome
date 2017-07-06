<img src="https://github.com/smartrome/minerva/blob/master/logo-png.png" height="94" height="71">

## Welcome! We present you the Minerva application!
<b>An interactive Android-based solution
for enriching the cultural experience in the Eternal City.</b>
<h3><a id="user-content-table-of-contents" class="anchor" href="#table-of-contents" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Table of Contents</h3>

<ul>
<li><a href="#Objectives">Our Objectives</a>
<li><a href="#good">Good to Know</a>
<ul>
<li><a href="#arc">Architecture</a></li>
<li><a href="#design">Design</a></li>
<li><a href="#road">Roud Map</a></li>
<li><a href="#video">Videos</a></li>
</ul>
</li>
<li><a href="#why">Why Minerva?</a></li>
<li><a href="#license">License</a></li>
<li><a href="#contributions">Contributions</a></li>
</ul>
<h2><a id="user-content-templates" class="anchor" href="#Objectives" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Our Objectives</h2>

Development of an Android application which takes the camera mirror image, and retrieves from the cloud interactive information about the place it's aiming. Currently the landmark recognition feature provided by the Google Cloud Vision API. Click <a href="https://cloud.google.com/vision/?gclid=CL2PjYatitMCFUORGwodg-kJpQ">here</a> to know more about this technology offered by Google. The Minerva application has been thought for being used in Rome, but the application offers the landmark recognition service world-wide.

<h2><a id="user-content-templates" class="anchor" href="#good" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Good to know</h2>

<h3><a id="user-content-table-of-contents" class="anchor" href="#arc" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Architecture</h3>

<table>
<thead>
<tr>
<th>Name</th>
<th>Screenshot</th>
</tr>
</thead>
<tbody>

<tr>
<td><a href="http://webthemez.com/techro-free-responsive-bootstrap-web-template/">Architecure</a></td>
<td><a href="http://www.expertsystem.com/wp-content/uploads/2015/10/Google-CloudPlatform_VerticalLockup.png" target="_blank"><img src="
http://www.expertsystem.com/wp-content/uploads/2015/10/Google-CloudPlatform_VerticalLockup.png" alt="techro" style="max-width:100%;"></a></td>
</tr>
<tr>
<td><a href="http://shapebootstrap.net/item/xeon-best-onepage-site-template/">Xeon</a></td>
<td><a href="/therebelrobot/awesome-bootstrap/blob/master/screenshots/spa-xeon.png" target="_blank"><img src="/therebelrobot/awesome-bootstrap/raw/master/screenshots/spa-xeon.png" alt="xeon" style="max-width:100%;"></a></td>
</tr></tbody></table>
<h3><a id="user-content-admin-dashboards" class="anchor" href="#admin-dashboards" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Admin Dashboards</h3>
<table>
<thead>
<tr>
<th>Name</th>
<th>Screenshot</th>
</tr>
</thead>
<tbody>
<tr>
<td><a href="https://github.com/akveo/blur-admin">Blur Admin</a></td>
<td><a href="/therebelrobot/awesome-bootstrap/blob/master/screenshots/admin-blur.png" target="_blank"><img src="/therebelrobot/awesome-bootstrap/raw/master/screenshots/admin-blur.png" alt="responsive" style="max-width:100%;"></a></td>
</tr>
<tr>
<td><a href="https://github.com/puikinsh/gentelella">Gentelella</a></td>
<td><a href="/therebelrobot/awesome-bootstrap/blob/master/screenshots/admin-gentelella.png" target="_blank"><img src="/therebelrobot/awesome-bootstrap/raw/master/screenshots/admin-gentelella.png" alt="responsive" style="max-width:100%;"></a></td>
</tr>
<tr>
<td><a href="http://www.prepbootstrap.com/bootstrap-theme/lightway-admin">lightway</a></td>
<td><a href="/therebelrobot/awesome-bootstrap/blob/master/screenshots/admin-lightway.png" target="_blank"><img src="/therebelrobot/awesome-bootstrap/raw/master/screenshots/admin-lightway.png" alt="lightway" style="max-width:100%;"></a></td>
</tr>
<tr>
<td><a href="https://github.com/Ehesp/Responsive-Dashboard">Responsive Dashboard</a></td>
<td><a href="/therebelrobot/awesome-bootstrap/blob/master/screenshots/admin-responsive.png" target="_blank"><img src="/therebelrobot/awesome-bootstrap/raw/master/screenshots/admin-responsive.png" alt="responsive" style="max-width:100%;"></a></td>
</tr>
<tr>
<td><a href="https://github.com/akveo/ng2-admin">ng2-admin</a></td>
<td><a href="https://camo.githubusercontent.com/f3344f0f67d1b8c24f0d98b50ff01a75a3338b74/68747470733a2f2f692e696d6775722e636f6d2f596761774745442e706e67" target="_blank"><img src="https://camo.githubusercontent.com/f3344f0f67d1b8c24f0d98b50ff01a75a3338b74/68747470733a2f2f692e696d6775722e636f6d2f596761774745442e706e67" alt="ng3-admin" data-canonical-src="https://i.imgur.com/YgawGED.png" style="max-width:100%;"></a></td>
</tr></tbody></table>
<h3><a id="user-content-retro-themes" class="anchor" href="#retro-themes" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Retro Themes</h3>
<table>










<h2><a id="user-content-templates" class="anchor" href="#why" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Why Minerva?</h2>
Minerva was the Roman goddess of wisdom, knowledge & the sponsor of arts. Through her name we want to transmit to the user the feeling that our solution in development is the right choice for letting him/her know quickly about whichever cultural spot that he/she might find in Rome.

Please find below our contacts and our last project documentation (slides, videos and a technical report about the application). The source code is also available for download in this repository. Any feedback for the project is greatly welcome :-)



<h2><a id="user-content-templates" class="anchor" href="#contributions" aria-hidden="true"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewBox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Contributions</h2>

- <b>Julio César Carrasquel</b>
  - <img src="https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAANyAAAAJGRlZTNlZDQwLTk4YTItNDA1MS04MzBjLWJmNGQ5M2RmZGUxYw.png" height="20" width="20"> <b>Linkedin</b>:  <a href="https://www.linkedin.com/in/julio-c%C3%A9sar-carrasquel-b5729844/">https://www.linkedin.com/in/julio-césar-carrasquel-b5729844/</a> 
  - <img id="imageLogo" class="logo-image" src="http://www.freeiconspng.com/uploads/iconmonstr-email-4-icon-27.png" alt="iconmonstr email 4 icon" style="border-width:0px;" height="20" width="20"> <b>Email</b>: carrasquelgamez.1726154@studenti.uniroma1.it
- <b>Razieh Akbari</b>
  -  <img src="https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAANyAAAAJGRlZTNlZDQwLTk4YTItNDA1MS04MzBjLWJmNGQ5M2RmZGUxYw.png" height="20" width="20"> <b>Linkedin</b>:  <a href="https://www.linkedin.com/in/razieh-akbari-2019b075/"> https://www.linkedin.com/in/razieh-akbari-2019b075/</a>
  - <img id="imageLogo" class="logo-image" src="http://www.freeiconspng.com/uploads/iconmonstr-email-4-icon-27.png" alt="iconmonstr email 4 icon" style="border-width:0px;" height="20" width="20"> <b>Email</b>: raziehakbari409@gmail.com
  
<b>Updates:</b>
<p><b>Take a look at our project step by step presentations on Slideshare and other material!</b></p>
  <p>- <a href="http://www.slideshare.net/juliocesarcarrasquel/team-presentation-and-project-proposal">First Presentation</a> - Team presentation and project proposal.</p>
  <p>- <a href="https://www.slideshare.net/RaziehAkbari/minerva-second-presentation">Second Presentation</a> - User Experience and System Design.</p>
  <p>- <a href="https://www.slideshare.net/RaziehAkbari/minerva-75560233">Third Presentation</a> - Introductory slides used for the presentation of our MVP.</p>
  <p>- <a href="https://www.slideshare.net/RaziehAkbari/minerva-exam-presentation">Exam Presentation</a> - Exam Presentation held on La Sapienza University July, 7th 2017 <img src="http://www.iconsdb.com/icons/preview/deep-pink/new-xxl.png" height="30" width="30"></p>
  <p>- <a href="https://youtu.be/ESH9aoOsrTY">Minerva Presentation</a> - A nice presentation on YouTube of our application! <img src="http://www.iconsdb.com/icons/preview/deep-pink/new-xxl.png" height="30" width="30"></p>
  <p>- <a href="https://youtu.be/WdBYzg6CeVg">Minerva Gallery Test</a> - A video on YouTube testing using an image of the device's gallery <img src="http://www.iconsdb.com/icons/preview/deep-pink/new-xxl.png" height="30" width="30"></p>
  
   <p>- <a href="  https://youtu.be/So76zOb8fTU">Minerva Camera Test</a> - A video on YouTube testing using an image of the device's Camera <img src="http://www.iconsdb.com/icons/preview/deep-pink/new-xxl.png" height="30" width="30"></p>
   
  <p>- <a href="https://www.slideshare.net/juliocesarcarrasquel/minerva-solution-technical-report"> Technical Report </a> - A paper presenting a technical review of the application as well as other general considerations. <img src="http://www.iconsdb.com/icons/preview/deep-pink/new-xxl.png" height="30" width="30"></p>
