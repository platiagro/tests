package ws


class Payloads{

        def wsPayloads = [
                    security:"""
                            <soapenv:Header>
                                <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" soapenv:mustUnderstand="1">
                                   <wsse:UsernameToken>
                                      <wsse:Username>@username</wsse:Username>
                                      <wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest">@passwordB64</wsse:Password>
                                      <wsse:Nonce EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary">@nonceB64</wsse:Nonce>
                                      <wsu:Created>@createdDate</wsu:Created>
                                   </wsse:UsernameToken>
                                </wsse:Security>
                             </soapenv:Header>"""
        ]

        def populatePayload(payloadKey, parameters){
            def payload = wsPayloads[payloadKey]
            parameters.each{ k, v ->
              if(payload.contains("@$k")){
                payload = payload.replace("@$k", v)
              }
            }
            payload
        }

}
