import * as React from 'react';
import {Button} from "antd-mobile";
import {inject, observer} from "mobx-react";
//
import {BaseProps} from "@/types/props.interface";

//
export interface HomePageProps extends BaseProps {
}

/**
 * 首页
 */
@inject('store')
@observer
export default class HomePage extends React.Component<HomePageProps> {

    render() {
        return (
            <div>
                <Button>React Application</Button>
            </div>
        );
    }

}
