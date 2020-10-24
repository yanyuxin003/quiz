import React, { Component } from 'react';
import './App.css';
import Header from './components/header';
import Goods from './components/goods';
import Orders from './components/orders';
import AddGoods from './components/addGoods';
import Home from './components/home';
import ShoppingCart from "./components/shoppingCart";
import {BrowserRouter, Switch, Route} from 'react-router-dom';

class App extends Component {

  render() {
    return (
        <BrowserRouter>
            <div className="App">
                <Header />
                <Switch>
                    <Route exact path='/' component={Home} />
                    <Route path='/goods' component={Goods} />
                    <Route path='/addgoods' component={AddGoods} />
                    <Route exact path='/orders' component={Orders} />
                    <Route path='/shoppingCart' component={ShoppingCart} />
                    {/*<Route path='./ad' component={ShoppingCart} />*/}
                </Switch>
            </div>
        </BrowserRouter>
    );
  }
}
export default App;
