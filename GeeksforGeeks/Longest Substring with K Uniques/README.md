<h2><a href="#">Longest Substring with K Uniques</a></h2>
<h3>Medium</h3>
<hr>

<p>Given a string <code>s</code> consisting only of lowercase English letters and an integer <code>k</code>, return the length of the <strong>longest substring</strong> that contains <strong>exactly</strong> <code>k</code> distinct characters.</p>

<p><strong>Note:</strong> If no such substring exists, return <code>-1</code>.</p>

<p>&nbsp;</p>

<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "aabacbebebe", k = 3
<strong>Output:</strong> 7
<strong>Explanation:</strong> The longest substring with exactly 3 distinct characters is <strong>"cbebebe"</strong>, which contains the distinct characters 'c', 'b', and 'e'.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "aaaa", k = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no substring that contains exactly 2 distinct characters.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "aabaaab", k = 2
<strong>Output:</strong> 7
<strong>Explanation:</strong> The entire string <strong>"aabaaab"</strong> contains exactly 2 distinct characters ('a' and 'b'), making it the longest valid substring.
</pre>

<p>&nbsp;</p>

<p><strong>Constraints:</strong></p>

<ul>
    <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
    <li><code>1 &lt;= k &lt;= 26</code></li>
    <li><code>s</code> consists only of lowercase English letters.</li>
</ul>
