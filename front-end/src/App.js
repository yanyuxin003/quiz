import React, { Component } from 'react';
import './App.css';
import Header from './components/header';
import Products from './components/products';
import ShoppingCart from "./components/shoppingCart";
import {BrowserRouter, Switch, Route} from 'react-router-dom';

class App extends Component {

  render() {
    return (
        <BrowserRouter>
            <div className="App">
                <Header />
                <Switch>
                    <Route path='./components/products' component={Products} />
                    <Route path='./components/shoppingCart' component={ShoppingCart} />
                </Switch>
            </div>
        </BrowserRouter>
    );
  }
}
export default App;
