import React, {Component} from 'react';
import '../styles/addgoods.css';
import { Input } from 'antd';

class addGoods extends Component {
    State= ({
        handleFlag: false,
    })

    addGood = () => {
        this.setState({
            handleFlag: true,
        })
        URL = `http://localhost:8080/goods/${this.props.good.id}`
        fetch(URL, {
            method:"POST",
        }).then(Response => {
            if (Response.status === 200) {
                this.setState({
                    handleFlag: false,
                })
            }
            else {
                this.setState({
                    handleFlag: false,
                })
                Promise.reject();
            }
        });
        alert("添加成功！")
    }

    render() {
        let url = JSON.stringify(this.props.url);
        console.log(url)
        return (
            <div className="addgood">
              <h2>添加商品</h2>
                <div className="add">名称：<Input placeholder="" /></div>
                <div className="add">价格：<Input placeholder="" /></div>
                <div className="add">单位：<Input placeholder="" /></div>
                <div className="add">图片：<Input placeholder="" /></div>
                <div className="tijiao"><button className="add" onChange={this.addGood}>提交</button> </div>
           </div>
        )
    }
}
export default addGoods;