const ticket = 'HoagFKDcsGMVCIY2vOjf9hXES-T9ZxYMU_Xq7-aekRNDfN1iRV_V9uGB5VRtnLWLymkQDlPZBLCqes0ng8oXGQ';
//const token = "18_OwMWjPfAe5LwykqxIWSdUsjFkPAnF64vfAmIYexIIoYm9Rqh3WHtSvTE6kjdrKHdkX9S3KtlWtNuGiggeWFVtHc49tMAGHswabn7_wzftpfyRpVG1rTi6sYW88eR95stkBVN6T668qrWIYYcDFWbAEAZBS";

const timestamp = Date.now();
const nonceStr = Math.random().toString(16).substr(2);

const urlStr = location.href;

const originParams = 'jsapi_ticket=' + ticket
    + '&noncestr=' + nonceStr
    + '&timestamp=' + timestamp
    + '&url=' + urlStr;

var shaObj = new jsSHA("SHA-1", "TEXT");
shaObj.update(originParams);
var signature = shaObj.getHash("HEX");
wx.config({
    debug: true,
    appId: 'wx1521489e601b0199',
    timestamp: timestamp,//必填，生成签名的时间戳
    nonceStr: nonceStr,//生成签名的随机数
    signature: signature,//签名
    jsApiList: [
        'checkJsApi',
        'chooseImage',
        'getLocation',
        'openLocation',
        'scanQRCode'
    ]//需要使用的JS接口列表
})


wx.error(function (error) {
    console.error(error)
});
wx.ready(function () {
    console.log('验证成功');
    console.log(signature);
});
wx.app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    },
    methods: {
        handlerCheckInOut() {
            console.log('check inout click');
        },
        checkJsApi() {
            console.log('checkJsApi click');
            wx.checkJsApi({
                jsApiList: ['chooseImage'],//需要检测的JS接口列表，所有JS接口列表见附录2
                success: function (res) {
                    console.log(res);
                }, fail: function (error) {
                    console.log(error);
                }
            });
        },
        chooseImage() {
            console.log('chooseImage click');
            wx.chooseImage({
                count: 2,//默认9
                sizeType: ['original', 'compressed'],//可以指定是原图还是压缩图，默认二者都有
                sourceType: ['album', 'camera'],//可以指定来源是相册还是相机，默认二者都有
                success: function (res) {
                    console.log(res);
                }, fail: function (err) {
                    console.error(err);
                }

            });
        },
        getLocation(){
            console.log('getLocation click');
            wx.getLocation({
                type: 'wgs84',//默认为wg84的GPS坐标，如果要返回直接给openLocation用的火星坐标，可传入gcj02
                success:function (res) {
                    console.log(res);
                    wx.openLocation({
                        latitude: res.latitude,//维度，浮点数，范围为90~-90
                        longitude: res.longitude,//经度，浮点数，范围为180~-180.
                        name: '',//位置名
                        address: '',//地址详情说明
                        scale: 20,//地图缩放级别，整形值，范围从1~28.默认为最大
                        infoURL: '',//查看位置界面底部显示的超链接，可点击跳转
                        success:function (res) {
                            console.log(res);
                        },
                        fail:function (err) {
                            console.log(err);
                        }
                    });
                },fail:function (err) {
                console.log(err);
            },
            });
        },


        openLocation(){
            console.log('openLocation click');
            wx.openLocation({
                latitude: 0,//维度，浮点数，范围为90~-90
                longitude:0,//经度，浮点数，范围为180~-180
                name:'',//位置名
                address:'',//地图详情说明
                scale:1,//地图缩放级别，整形值，范围1~28.默认为最大
                infoURL:'',//在查看位置界面底层线束的超链接，可点击跳转
                success:function (res) {
                    console.log(res);
                },fail:function (err) {
                    console.log(err);
                }
            });
        },



        scanQRCode(){
            console.log('scanQRCode click');
            wx.scanQRCode({
                needResult:1,//默认为0，扫描结果由微信处理，1则直接返回扫描结果，
                scanType:["qrCode","barCode"],//可以指定扫二维码还是一维码，默认二维码
                success:function (res) {
                    console.log(res);
                },fail:function (err) {
                    console.log(err);
                }
            });
        }








    }
})




