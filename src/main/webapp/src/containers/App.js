import React from 'react';
import Header from '../components/Header/Header'
import '../css/App.css';

function App() {
	return (
		<div className="App">
			<Header url={'https://reactjs.org'} title={'Learn React'} />
		</div>
	);
}

export default App;
