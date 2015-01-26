<!DOCTYPE html>

<html>
  <head>
    <title>Sign Up</title>
    <style type="text/css">
      .label {text-align: right}
      .error {color: red}
    </style>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script>
  </head>

  <body>
      <form method="post">
      <table>



        <tr>
          <td class="label">
            Consignment
          </td>
          <td>
            <input type="text" name="consignmentId" value="${consignmentId}">
          </td>

        </tr>

        <tr>
          <td class="label">
            From Location
          </td>
          <td>
            <input type="text" name="fromLoc" value="${fromLoc}">
          </td>

        </tr>

        <tr>
          <td class="label">
            To Location
          </td>
          <td>
            <input type="text" name="toLoc" value="${toLoc}">
          </td>

        </tr>

        <tr>
          <td class="label">
            Booking Date
          </td>
          <td>
            <input type="text" name="bookDate" value="${bookDate}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Booking Branch Name
          </td>
          <td>
            <input type="text" name="bookingBranch" value="${bookingBranch}">
          </td>
         </tr>

        <tr>
          <td class="label">
            Consignor
          </td>
          <td>
            <input type="text" name="consignor" value="${consignor}">
          </td>
        </tr>
        <tr>
          <td class="label">
            Consignee
          </td>
          <td>
            <input type="text" name="consignee" value="${consignee}">
          </td>
        </tr>
        <tr>
          <td class="label">
            Service Tax Paid by:
          </td>
          <td>
            <input type="text" name="stPaid" value="${stPaid}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Booking For:
          </td>
          <td>
            <input type="text" name="bookingFor" value="${bookingFor}">
          </td>
        </tr>
        <tr>
          <td class="label">
            Mode
          </td>
          <td>
            <input type="text" name="mode" value="${mode}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Bank Billty
          </td>
          <td>
            <input type="text" name="Billty" value="${Billty}">
          </td>
        </tr>
        <tr>
          <td class="label">
            Bank Billty
          </td>
          <td>
            <input type="text" name="Billty" value="${Billty}">
          </td>
        </tr>

        <tr>
          <td class="label">
            CN Type
          </td>
          <td>
            <input type="text" name="cnType" value="${cnType}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Freight Charge
          </td>
          <td>
            <input type="text" name="freightCharge" value="${freightCharge}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Packages
          </td>
          <td>
            <input type="text" name="packages" value="${packages}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Package Type
          </td>
          <td>
            <input type="text" name="packageType" value="${packageType}">
          </td>
        </tr>

        <tr>
          <td class="label">
            A Weight
          </td>
          <td>
            <input type="text" name="aWeight" value="${aWeight}">
          </td>
        </tr>

        <tr>
          <td class="label">
            C Weight
          </td>
          <td>
            <input type="text" name="cWeight" value="${cWeight}">
          </td>

        </tr>

        <tr>
          <td class="label">
            Party CH No.
          </td>
          <td>
            <input type="text" name="partyCH" value="${partyCH}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Contains
          </td>
          <td>
            <input type="text" name="contains" value="${contains}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Type
          </td>
          <td>
            <input type="text" name="type" value="${type}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Billed On
          </td>
          <td>
            <input type="text" name="billedOn" value="${billedOn}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Value
          </td>
          <td>
            <input type="text" name="value" value="${value}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Rate
          </td>
          <td>
            <input type="text" name="rate" value="${rate}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Truck No
          </td>
          <td>
            <input type="text" name="truckNo" value="${truckNo}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Advance
          </td>
          <td>
            <input type="text" name="advance" value="${advance}">
          </td>
        </tr>

        <tr>
          <td class="label">
            Private Mark
          </td>
          <td>
            <input type="text" name="private" value="${private}">
          </td>
        </tr>


      </table>
        <table>
                <tr>
                  <td class="label">
                    Freight
                  </td>
                  <td>
                    <input type="text" name="freight" value="${freight}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    Hamali
                  </td>
                  <td>
                    <input type="text" name="hamali" value="${hamali}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    Surcharge
                  </td>
                  <td>
                    <input type="text" name="surcharge" value="${surcharge}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    ST. Surcharge
                  </td>
                  <td>
                    <input type="text" name="stSurcharge" value="${stSurcharge}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    ST. CH
                  </td>
                  <td>
                    <input type="text" name="stCharge" value="${stCharge}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    Risk Charge
                  </td>
                  <td>
                    <input type="text" name="riskCharge" value="${riskCharge}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    Door Delivery
                  </td>
                  <td>
                    <input type="text" name="doorDel" value="${doorDel}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    Misc. Charge
                  </td>
                  <td>
                    <input type="text" name="miscCharge" value="${miscCharge}">
                  </td>
                </tr>

                <tr>
                  <td class="label">
                    Total
                  </td>
                  <td>
                    <input type="text" name="total" >
                  </td>
                </tr>
            </table>
      <input type="submit">

      <input type="button" id="addOption" value="Add" onClick='<input type="text">'/>
    </form>



  </body>

</html>
