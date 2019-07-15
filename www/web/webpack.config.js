const path = require('path');
const webpack = require('webpack');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const TSConfigPathsPlugin = require('tsconfig-paths-webpack-plugin');
const WebpackBundleAnalyzer = require('webpack-bundle-analyzer');
const tsImportPluginFactory = require('ts-import-plugin');

const env = process.env.environment === "production" ? "production" : "development";
console.log(`environment - ${env}`);

module.exports = {
    entry : [
        './src/index.tsx'
    ],
    output : {
        path : path.join(__dirname, 'dist'),
        filename : '[name].js'
    },
    module : {
        rules : [{
            test : /\.ts|\.tsx?$/,
            exclude : /node_modules/,
            use : [{
                loader : 'ts-loader',
                options : {
                    transpileOnly : true,
                    getCustomTransformers : () => ({
                        before : [tsImportPluginFactory([{
                            libraryName : 'antd',
                            libraryDirectory : 'lib',
                            style : true
                        }, {
                            libraryName : 'antd-mobile',
                            libraryDirectory : 'lib',
                            style : true
                        }, {
                            libraryName : 'lodash',
                            libraryDirectory : null,
                            style : false,
                            camel2DashComponentName : false
                        }])]
                    })
                },
            }]
        }, {
            test : /\.html$/,
            use : [{
                loader : "html-loader",
                options : {
                    minimize : true
                }
            }]
        }, {
            test : /\.(css|less)$/,
            use : [{
                loader : MiniCssExtractPlugin.loader
            }, {
                loader : 'css-loader'
            }, {
                loader : 'less-loader',
                options : {
                    javascriptEnabled : true
                }
            }]
        }, {
            test : /\.(ttf|eot)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
            loader : 'file-loader'
        }, {
            test : /\.(jpe?g|png|gif|svg)$/i,
            loader : 'file-loader'
        }]
    },
    resolve : {
        extensions : [".ts", ".tsx", ".js", ".jsx", ".json"],
        alias : {
            'react-dom' : '@hot-loader/react-dom'
        },
        plugins : [new TSConfigPathsPlugin.TsconfigPathsPlugin({})]
    },
    plugins : [
        new webpack.NormalModuleReplacementPlugin(
            /src\/environments\/environment\.ts/,
            './environment.' + env + '.ts/'
        ),
        new MiniCssExtractPlugin({
            filename : '[name].css'
        }),
        new HtmlWebpackPlugin({
            filename : 'index.html',
            template : path.resolve(__dirname, './public/index.html')
        }),
        new WebpackBundleAnalyzer.BundleAnalyzerPlugin(),
        new webpack.IgnorePlugin(/^\.\/locale$/, /moment$/),
    ]
};
