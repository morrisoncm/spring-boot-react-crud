import React from 'react';
import '../../css/Header.css'
import logo from '../../logo.svg';

const Header = ({ url, title }) => (
	<header className='App-header'>
		<img src={logo} className='App-logo' alt='logo' />
		<p>
			Edit <code>src/containers/App.js</code> and save to reload.
		</p>
		<a href={url} className='App-link' target='_blank' rel='noopener noreferrer'>
			{title}
		</a>
	</header>
);

export default Header;