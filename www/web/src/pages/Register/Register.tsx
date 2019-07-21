import * as React from 'react';
import {Button, Card, Col, Form, Icon, Input, Row} from 'antd';
import * as intl from 'react-intl-universal';
import {inject, observer} from 'mobx-react';
//
import "./Register.less";
//
import environment from "@common/environments/environment";
import {UserService} from "@common/services";
import {handleValidationResult} from "@common/utils";

/**
 * RegisterPage
 */
@inject('store')
@observer
class RegisterPage extends React.Component<any, any> {
    /**
     * 登录处理
     */
    handleSubmit = (e: any) => {
        e.preventDefault();

        this.props.form.validateFields((err: any, values: any) => {
            if (!err) {
                UserService.register({
                    username: values.username,
                    password: values.password
                }).then(async (result: any) => {
                    if (result.status === 1) {
                        await this.props.store.loginSuccess(result.data.token);
                        this.props.history.push('/');
                    } else {
                        handleValidationResult(this, result);
                    }
                });
            }
        });
    };

    componentDidMount() {
        // 进入登陆页面清空所有之前登陆信息
        this.props.store.clear();
        // 如果测试环境初始开发账号方便调试
        if (!environment.production) {
            this.props.form.setFieldsValue({
                username: 'admin',
                password: '123456',
            });
        }
    };

    render() {
        const {getFieldDecorator} = this.props.form;

        return (
            <Row type="flex" align="middle">
                <Col span={6} offset={9}>
                    <Card className={'register-card'}
                          title={intl.get('user_page_register_title')}>
                        <Form onSubmit={this.handleSubmit}
                              className={'register-form'}>
                            <Form.Item>
                                {
                                    getFieldDecorator('username', {
                                        rules: [{
                                            message: intl.get("validation-required"),
                                            required: true,
                                        }],
                                    })(
                                        <Input prefix={<Icon type="user"/>}
                                               placeholder={intl.get("user_field_username")}/>
                                    )
                                }
                            </Form.Item>
                            <Form.Item>
                                {getFieldDecorator('password', {
                                    rules: [{
                                        message: intl.get("validation-required"),
                                        required: true,
                                    }],
                                })(
                                    <Input prefix={<Icon type="lock"/>}
                                           type="password"
                                           placeholder={intl.get("user_field_password")}/>
                                )}
                            </Form.Item>
                            <Form.Item>
                                <Button block type="primary" htmlType="submit">
                                    {intl.get("button_submit")}
                                </Button>
                            </Form.Item>
                        </Form>
                    </Card>
                </Col>
            </Row>
        )
    }
}

export default Form.create()(RegisterPage);
