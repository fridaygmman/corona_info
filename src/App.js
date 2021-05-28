import React from 'react';
import logo from './logo.svg';
import './App.css';


function App() {
  var xhr = new XMLHttpRequest();     // XMLHttpRequest() 객체 : 서버로부터 XML 데이터를 전송받아 처리
  var url = 'http://apis.data.go.kr/1741000/DisasterMsg3/getDisasterMsg1List'; /*URL*/
  var queryParams = '?' + encodeURIComponent('ServiceKey') + '='+'w7XDn2ZP9SRVjgyl64GF3CZylNLQpkB8FK8GHNZo6OGL0O%2BzaJnzmO8JQkTUR1heHigYwaspulhclYo1iFBwUQ%3D%3D'; /*Service Key*/
  queryParams += '&' + encodeURIComponent('ServiceKey') + '=' + 'w7XDn2ZP9SRVjgyl64GF3CZylNLQpkB8FK8GHNZo6OGL0O+zaJnzmO8JQkTUR1heHigYwaspulhclYo1iFBwUQ=='; /*인증키*/
  queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
  queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
  queryParams += '&' + encodeURIComponent('type') + '=' + encodeURIComponent('xml'); /**/
  xhr.open('GET', url + queryParams);
  xhr.onreadystatechange = function () {      // XMLHttpRequest 객체의 readyState 프로퍼티 값이 변할 때마다 자동으로 호출되는 함수
      if (this.readyState == 4) {             // readyState : UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.                                                         // LOADING (숫자 3) : 요청한 데이터를 처리 중임. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
           //var a = this.response;        // alert() : 팝업 형태로 알림   // 여기서 this 함수는 xhr 객체를 가리킴.
           var XMLParser = require('react-xml-parser');
           var xml = new XMLParser().parseFromString(this.response);    // Assume xmlText contains the example XML
           var xml_str = new XMLParser().toString(xml)
           //console.log(xml_str)
           //console.log(xml.getElementByTagName('location_name'))
      }
      return console.log(xml_str);
  };
  xhr.send('');

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          { xhr.onreadystatechange() }
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
