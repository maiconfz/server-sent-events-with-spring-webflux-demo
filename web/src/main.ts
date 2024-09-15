import './style.css';

let eventSource: EventSource = new EventSource('http://localhost:8080/msg-stream');

const msgs = document.querySelector('#msgs');

eventSource.onmessage = (event) => {
  let newMsg = document.createElement('span');
  newMsg.innerHTML = `${event.data}<br/>`;

  msgs?.prepend(newMsg);
};

eventSource.onerror = (error) => {
  let newMsg = document.createElement('span');
  newMsg.innerHTML = `${error}<br/>`;
  
  msgs?.prepend(newMsg);
};
