import React, { Component } from 'react';
import imgURL from '../assets/shopping.jpg';
import '../styles/header.css';
import {BrowserRouter, Switch, Route, Link} from 'react-router-dom';
import Products from "./Products";

class Header extends Component {
  render() {
    return (
        <BrowserRouter >
      <div className="header">
        <h1 className="store">商城</h1>
        <div>
            <img src={imgURL}></img>
            <Link to={"/products"}>Products</Link>
        </div>
        {/* 父类传值给子类 */}
        <p className="amount">{this.props.value}</p>
        <div className="clear"></div>
         </div>
  <Route  path={'/products'} component={Products}></Route>
        </BrowserRouter>
    );
  }
}

export default Header;