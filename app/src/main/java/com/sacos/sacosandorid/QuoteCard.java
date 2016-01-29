package com.sacos.sacosandorid;

/**
 * Created by renjith on 09/01/16.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;


public class QuoteCard extends Card {

    protected TextView mFromName;
    protected TextView mFromCode;
    protected TextView mFromDate;
    protected TextView mFromDay;
    protected TextView mToName;
    protected TextView mToCode;
    protected TextView mToDate;
    protected TextView mToDay;
    protected TextView mQuote;

    /**
     * Constructor with a custom inner layout
     *
     * @param context
     */
    public QuoteCard(Context context) {
        this(context, R.layout.activity_search_results_cell);
    }

    /**
     * @param context
     * @param innerLayout
     */
    public QuoteCard(Context context, int innerLayout) {
        super(context, innerLayout);
        init();
    }

    /**
     * Init
     */
    private void init() {

        //No Header

        /*
        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
        mFromCode = (TextView) parent.findViewById(R.id.result_from_code);
        mFromName = (TextView) parent.findViewById(R.id.result_from_name);
        mFromDate = (TextView) parent.findViewById(R.id.result_from_date);
        mFromDay  = (TextView) parent.findViewById(R.id.result_from_day);

        mToCode = (TextView) parent.findViewById(R.id.result_to_code);
        mToName = (TextView) parent.findViewById(R.id.result_to_name);
        mToDate = (TextView) parent.findViewById(R.id.result_to_date);
        mToDay  = (TextView) parent.findViewById(R.id.result_to_day);

        mQuote = (TextView) parent.findViewById(R.id.result_quote);


        if (mFromCode != null)
            mFromCode.setText("");

        if (mFromName != null)
            mFromName.setText("");

        if (mFromDate != null)
            mFromDate.setText("");

        if (mFromDay != null)
            mFromDay.setText("");

        if (mToCode != null)
            mToCode.setText("");

        if (mToName != null)
            mToName.setText("");

        if (mToDate != null)
            mToDate.setText("");

        if (mToDay != null)
            mToDay.setText("");

    }
}
