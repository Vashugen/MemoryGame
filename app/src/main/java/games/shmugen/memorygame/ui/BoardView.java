/*
package games.shmugen.memorygame.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shmugen.app.legends.R;
import com.shmugen.app.legends.utils.Utils;

import games.shmugen.memorygame.utils.Utils;

public class BoardView extends LinearLayout {

    private int mScreenWidth;
    private int mScreenHeight;

    public BoardView(Context context) {
        this(context, null);
    }

    public BoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);
        */
/*int margin = getResources().getDimensionPixelSize(R.dimen.);
        int padding = getResources().getDimensionPixelSize(R.dimen.board_padding);
        mScreenHeight = getResources().getDisplayMetrics().heightPixels - margin - padding * 2;
        mScreenWidth = getResources().getDisplayMetrics().widthPixels - padding * 2 - Utils.px(20);*//*

        */
/*

        mViewReference = new HashMap<Integer, TileView>();
        setClipToPadding(false);*//*

    }

    public static BoardView fromXml(Context context, ViewGroup parent) {
        //return (BoardView) LayoutInflater.from(context).inflate(R.layout.board_view, parent, false);
    }

*/
/*    public void setBoard(Game game) {

        mBoardConfiguration = game.boardConfiguration;
        mBoardArrangment = game.boardArrangment;
        // calc prefered tiles in width and height
        int singleMargin = getResources().getDimensionPixelSize(R.dimen.card_margin);
        float density = getResources().getDisplayMetrics().density;
        singleMargin = Math.max((int) (1 * density), (int) (singleMargin - mBoardConfiguration.difficulty * 2 * density));
        int sumMargin = 0;
        for (int row = 0; row < mBoardConfiguration.numRows; row++) {
            sumMargin += singleMargin * 2;
        }
        int tilesHeight = (mScreenHeight - sumMargin) / mBoardConfiguration.numRows;
        int tilesWidth = (mScreenWidth - sumMargin) / mBoardConfiguration.numTilesInRow;
        mSize = Math.min(tilesHeight, tilesWidth);

        mTileLayoutParams = new LinearLayout.LayoutParams(mSize, mSize);
        mTileLayoutParams.setMargins(singleMargin, singleMargin, singleMargin, singleMargin);

        // build the ui
        buildBoard();

    }

    *//*
*/
/**
     * Build the board
     *//*
*/
/*
    private void buildBoard() {

        for (int row = 0; row < mBoardConfiguration.numRows; row++) {
            // add row
            addBoardRow(row);
        }

        setClipChildren(false);
    }

    private void addBoardRow(int rowNum) {

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER);

        for (int tile = 0; tile < mBoardConfiguration.numTilesInRow; tile++) {
            addTile(rowNum * mBoardConfiguration.numTilesInRow + tile, linearLayout);
        }

        // add to this view
        addView(linearLayout, mRowLayoutParams);
        linearLayout.setClipChildren(false);
    }*//*

}
*/
