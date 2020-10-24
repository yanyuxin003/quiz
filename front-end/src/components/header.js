import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import '../styles/header.css';


class Header extends Component {
  render() {
    return (
        <div className="header">
            <div className="market">
                <p>
                    <Link className='toLink' to='/'>商城</Link>
                </p>
            </div >
            <div className="order">
                <p>
                    <Link className='toLink' to='/orders'>订单</Link>
                </p>
            </div>
            <div className="add-product">
                <p>
                    <Link className='toLink' to='/addgoods'>添加商品</Link>
                </p>
            </div>
        </div>
    );
  }
}

export default Header;