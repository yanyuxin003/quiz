import React, { Component } from 'react';
import imgURL from '../assets/shopping.jpg';
import '../styles/header.scss';

class Header extends Component {
  render() {
    return (
      <div className="header">
        <h1 className="store">Store</h1>
        <img src={imgURL}></img>
        {/* 父类传值给子类 */}
        <p className="amount">{this.props.value}</p>
        <div className="clear"></div>
      </div>
    );
  }
}

export default Header;