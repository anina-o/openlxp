import * as React from 'react';
import {inject, observer} from "mobx-react";
//
import {BaseProps, FormProps, RouteProps} from "@/types/props.interface";
import DefaultLayout from "@/components/Layout/DefaultLayout";

/**
 * HomePageProps
 */
interface HomePageProps extends FormProps, RouteProps, BaseProps {
}

/**
 * 首页
 */
@inject('store')
@observer
export default class HomePage extends React.Component<HomePageProps> {

    render() {
        return (
            <DefaultLayout>
                Home<br/>
            </DefaultLayout>
        );
    }

}
