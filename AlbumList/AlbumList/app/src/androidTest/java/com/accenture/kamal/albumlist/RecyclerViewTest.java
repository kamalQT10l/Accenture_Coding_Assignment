package com.accenture.kamal.albumlist;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.accenture.kamal.albumlist.View.AlbumActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.fail;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by kamalakannanb on 07/01/19.
 */

@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest {
    @Rule
    public ActivityTestRule<AlbumActivity> mActivityRule = new ActivityTestRule<>(AlbumActivity.class);

    @Test
    public void testMainActivityMovieSearch() throws InterruptedException
    {
        // Check that list adapter is set and views populated
        RecyclerView recyclerView = (RecyclerView) mActivityRule.getActivity().findViewById(R.id.recycler);
        waitForCondition(() -> recyclerView != null && recyclerView.getAdapter() != null, 3000);
        assertNotNull(recyclerView);
        assertNotNull(recyclerView.getAdapter());
        assertNotSame(0, recyclerView.getAdapter().getItemCount());
    }

    /**
     * Wait for the specific time using {@link Thread#sleep(long
     * @param milliseconds The time we want to wait for in millis
     */
    protected void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Wait for a condition to be true
     * @param condition The condition we want to be true
     * @param time      The time to wait for
     */
    protected void waitForCondition(Condition condition, int time) {
        int timeWaited = 0;
        while (timeWaited < time) {
            if (condition.isSatisfied()) {
                return;
            }
            waitFor(200);
            timeWaited += 200;
        }
    }

    public interface Condition {
        boolean isSatisfied();
    }
}

