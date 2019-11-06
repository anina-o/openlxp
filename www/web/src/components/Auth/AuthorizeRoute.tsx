import * as React from 'react';
import {Redirect, Route} from 'react-router-dom';
import Authorize from './Authorize';

/**
 * 认证路由
 */
export default class AuthorizeRoute extends React.Component<any, any> {
    render() {
        const {
            component : Component,
            render,
            authority,
            redirectPath,
            ...rest
        } = this.props;

        return (
            <Authorize
                authority={authority}
                noMatch={
                    <Redirect to={{
                        pathname : redirectPath ? redirectPath : "/login",
                        state : {from : this.props.location}
                    }}
                    />
                }>
                <Route
                    {...rest}
                    render={(props) =>
                        (Component ? <Component {...props} /> : render(props))
                    }
                />
            </Authorize>
        );
    }
}
