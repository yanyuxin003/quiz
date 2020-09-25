import React, { Component } from 'react';
import './App.css';
import Header from './components/header';
import ShopItem from './components/shopItem';
import Products from "./components/Products";
import {BrowserRouter, Switch, Route, Link} from 'react-router-dom';

class App extends Component {
   state = {
    count: 0,
   };

  buyItem = () => {
    this.setState({
      count: this.state.count + 1,
    });
    console.log(this.state.count);
  };
  render() {
    return (
        <main className="app">
          <Header value = {this.state.count} />
          {/*<h2>iPhone</h2>*/}
          {/*<table className="iPhone">*/}
          {/*  <tr>*/}
          {/*    <td>*/}
          {/*      <ShopItem name="iPhone11" price="￥5999" buyItem = {this.buyItem}/>*/}
          {/*    </td>*/}
          {/*    <td>*/}
          {/*      <ShopItem name="iPhoneXS" price="￥5399" buyItem = {this.buyItem}/>*/}
          {/*    </td>*/}
          {/*    <td>*/}
          {/*      <ShopItem name="iPhoneSE" price="￥3599" buyItem = {this.buyItem}/>*/}
          {/*    </td>*/}
          {/*  </tr>*/}
          {/*</table>*/}

          {/*<h2>HuaWei</h2>*/}
          {/*<table className="HuaWei">*/}
          {/*  <tr>*/}
          {/*    <td>*/}
          {/*      <ShopItem name="HuaWei P40 Pro+" price="￥7999" buyItem = {this.buyItem}/>*/}
          {/*    </td>*/}
          {/*    <td>*/}
          {/*      <ShopItem name="HuaWei Mate 30" price="￥5000" buyItem = {this.buyItem}/>*/}
          {/*    </td>*/}
          {/*    <td>*/}
          {/*      <ShopItem name="HuaWei nova 7" price="￥4000" buyItem = {this.buyItem}/>*/}
          {/*    </td>*/}
          {/*  </tr>*/}
          {/*</table>*/}

          {/*<BrowserRouter >*/}
          {/*  <div className="app">*/}
          {/*    <Header*/}
          {/*    <ul>*/}
          {/*      <li>*/}
          {/*        <Link to={"/products"}>Products</Link>*/}
          {/*      </li>*/}
          {/*    </ul>*/}
          {/*    </Header>*/}
          {/*    <Route  path={'/products'} component={Products}></Route>*/}
          {/*  </div>*/}
          {/*</BrowserRouter>*/}
        </main>
    );
  }
}
export default App;
